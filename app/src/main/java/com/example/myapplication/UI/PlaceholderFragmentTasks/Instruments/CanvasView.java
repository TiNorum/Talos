package com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication.Instruments.Constants;

import java.io.Serializable;
import java.util.ArrayList;

public class CanvasView extends View implements Serializable {

    private static final long serialVersionUID =1;
    private  final int col = 15, row = 15;
    private int WIDTH;
    private int HEIGHT;
    private float margin_field, size_line;
    public Field selected_field;
    private  final String chars = "АБВГДЕКЛМН";
    private String usedChars = "";

    private Field[][] field = new Field[row][col];

    Paint p, p_selected, p_text, p_line;


    // переменные для перетаскивания
    float[] lineSelected;
    boolean drag = false;
    float dragX = 0;
    float dragY = 0;


    public CanvasView(Context context) {
        super(context);

        p_selected = new Paint();
        p_selected.setColor(Color.GRAY);

        p_line = new Paint();
        p_line.setStrokeWidth(10);
        p_line.setColor(Color.BLACK);

        p_text = new Paint();
        p_text.setTextSize(60);
        p_text.setColor(Color.RED);

        p = new Paint();
        p.setStrokeWidth(2);
        p.setColor(Color.BLACK);
        invalidate();

    }

    public CanvasView(Context context,AttributeSet attrs) {
        super(context,attrs);

        p_selected = new Paint();
        p_selected.setColor(Color.GRAY);

        p_line = new Paint();
        p_line.setStrokeWidth(10);
        p_line.setColor(Color.BLACK);

        p_text = new Paint();
        p_text.setTextSize(60);
        p_text.setColor(Color.RED);

        p = new Paint();
        p.setStrokeWidth(2);
        p.setColor(Color.BLACK);
        invalidate();

    }


    private void initField() {
        float x, y = margin_field;
        for (int i = 0; i < row; i++) {
            x = size_line;
            for (int j = 0; j < col; j++) {
                field[i][j] = new Field(x, y);
                x += size_line;
            }
            y += size_line;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        printField(canvas);

    }

    public boolean isEmpty() {

        return usedChars.isEmpty();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        WIDTH = w;
        HEIGHT = h;
        margin_field = (h - w) >> 1;
        size_line = WIDTH >> 4;
        initField();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // координаты Touch-события
        float evX = event.getX();
        float evY = event.getY();
        switch (event.getAction()) {
            // касание началось
            case MotionEvent.ACTION_DOWN:


                //если касание началось за пределами отрисовки
                if (!(evX >= field[0][0].x - size_line / 2
                        && evX <= field[row - 1][col - 1].x + size_line / 2
                        && evY >= field[0][0].y - size_line / 2
                        && evY <= field[row - 1][col - 1].y + size_line / 2))
                    break;

                //местто нажатия
                int i = Math.round(evX / size_line - 1),
                        j = Math.round((evY - margin_field) / size_line);

                Field touch = field[j][i];


                //если нажатие было на пустое место и выделеного круга нет
                if (!touch.circle && selected_field == null) {
                    if (neighbor(i, j)) {


                        for (int l = 0; l < chars.length(); l++) {

                            if (!usedChars.contains("" + chars.charAt(l))) {
                                touch.character = "" + chars.charAt(l);
                                usedChars += touch.character;
                                touch.circle = true;
                                touch.textX = touch.x - size_line / 2;
                                touch.textY = touch.y - size_line / 2;
                                break;
                            }

                        }
                    }
                    break;
                }

                //если нажатие было на  выделенный круг
                if (touch == selected_field) {

                    selected_field.select = false;
                    selected_field.circle = false;

                    //убираем символ из используемых
                    StringBuilder buffer = new StringBuilder(usedChars);
                    buffer.deleteCharAt(usedChars.indexOf(selected_field.character));
                    selected_field.character = "";
                    usedChars = buffer.toString();
                    selected_field.chars_reset();
                    //убираем линии

                    for (int k = 0; k < selected_field.line.size(); k++) {
                        ;
                        Line line = selected_field.line.get(k);

                        Field temp = field[Math.round((line.y - margin_field) / size_line)][Math.round(line.x / size_line - 1)];

                        for (int index = 0; index < temp.line.size(); index++) {

                            if (temp.line.get(index).x == selected_field.x && temp.line.get(index).y == selected_field.y) {

                                temp.line.remove(index);
                                temp.remove_char(selected_field.character);
                                break;
                            }
                        }
                    }
                    selected_field.line.clear();
                    selected_field = null;
                    break;
                }

                //если    выделили круг
                if (selected_field == null && touch.circle) {
                    selected_field = touch;
                    selected_field.select = true;

                    // включаем режим перетаскивания
                    drag = true;
                    lineSelected = new float[4];
                    lineSelected[0] = selected_field.x;
                    lineSelected[1] = selected_field.y;

                    dragX = evX - selected_field.x;
                    dragY = evY - selected_field.y;
                    break;

                }

                if (selected_field != null) {
                    selected_field.select = false;
                    selected_field = null;
                    break;

                }


                break;


            case MotionEvent.ACTION_MOVE:
                // если режим перетаскивания включен

                if (drag && (evX >= field[0][0].x - size_line / 2
                        && evX <= field[row - 1][col - 1].x + size_line / 2
                        && evY >= field[0][0].y - size_line / 2
                        && evY <= field[row - 1][col - 1].y + size_line / 2)) {

                    lineSelected[2] = evX - dragX;
                    lineSelected[3] = evY - dragY;

                } else {
                    drag = false;
                    lineSelected = null;
                }
                invalidate();

                break;
            // касание завершено
            case MotionEvent.ACTION_UP:
                // выключаем режим перетаскивания
                int x0 = Math.round(evX / size_line - 1),
                        y0 = Math.round((evY - margin_field) / size_line);

                if (lineSelected != null) {
                    lineSelected[2] = field[y0][x0].x;
                    lineSelected[3] = field[y0][x0].y;


                    if (drag && field[y0][x0].circle &&
                            (evX >= field[0][0].x - size_line / 2
                                    && evX <= field[row - 1][col - 1].x + size_line / 2
                                    && evY >= field[0][0].y - size_line / 2
                                    && evY <= field[row - 1][col - 1].y + size_line / 2)
                            && !(lineSelected[2] == lineSelected[0] && lineSelected[3] == lineSelected[1])) {


                        boolean flag_line = true;
                        for (Line line : selected_field.line) {
                            if (line.x == lineSelected[2] && line.y == lineSelected[3]) {
                                flag_line = false;
                                break;
                            }
                        }

                        if (flag_line) {
                            selected_field.line.add(new Line(lineSelected[2], lineSelected[3]));
                            selected_field.add_char(field[y0][x0].character);
                            ;
                            field[y0][x0].line.add(new Line(lineSelected[0], lineSelected[1]));
                            field[y0][x0].add_char(selected_field.character);

                        }
                        selected_field.select = false;
                        selected_field = null;
                    }
                }

                drag = false;
                lineSelected = null;
                invalidate();
                break;
        }
        return true;
    }

    private boolean neighbor(int i, int j) {

        if (i == 0 && j == 0)
            return !(field[j + 1][i].circle || field[j][i + 1].circle);
        if (i == col - 1 && j == row - 1)
            return !(field[j - 1][i].circle || field[j][i - 1].circle);
        if (i == 0 && j == row - 1)
            return !(field[j - 1][i].circle || field[j][i + 1].circle);
        if (i == col - 1 && j == 0)
            return !(field[j + 1][i].circle || field[j][i - 1].circle);
        else if (i == 0)
            return !(field[j + 1][i].circle || field[j][i + 1].circle || field[j - 1][i].circle);
        else if (j == 0)
            return !(field[j + 1][i].circle || field[j][i + 1].circle || field[j][i - 1].circle);
        else if (i == col - 1)
            return !(field[j + 1][i].circle || field[j][i - 1].circle || field[j - 1][i].circle);
        else if (j == row - 1)
            return !(field[j - 1][i].circle || field[j][i + 1].circle || field[j][i - 1].circle);
        else
            return !(field[j + 1][i].circle || field[j - 1][i].circle || field[j][i + 1].circle || field[j][i - 1].circle);

    }


    private void printField(Canvas canvas) {

        int margin = 0;

        //отрисовываем линию, которую пермещает пользователь
        if (lineSelected != null)
            canvas.drawLine(lineSelected[0], lineSelected[1], lineSelected[2], lineSelected[3], p_line);

        //отрисовываем линии


        for (int i = 0; i < row; i++) {
            //отрисовываем сетку
            canvas.drawLine(size_line, margin_field + margin, WIDTH - size_line, margin_field + margin, p);
            canvas.drawLine(margin + size_line, margin_field, margin + size_line, margin_field + size_line * (col - 1), p);
            margin += size_line;
            //отрисовываем круги
            for (Field sector : field[i]) {
                if (sector.circle) {

                    //отрисовываем линии
                    for (Line line : sector.line) {
                        canvas.drawLine(sector.x, sector.y, line.x, line.y, p_line);
                    }
                    //отрисовываем букву
                    canvas.drawText(sector.character, sector.textX, sector.textY, p_text);

                    //отрисовываем круг
                    if (sector.select)
                        canvas.drawCircle(sector.x, sector.y, size_line / 3, p_selected);
                    else
                        canvas.drawCircle(sector.x, sector.y, size_line / 3, p);
                }
            }
        }


    }

    @Override
    public String toString() {
        String[] str = new String[usedChars.length()];

        StringBuilder stringBuilder = new StringBuilder(usedChars);

        for (int i = 0; i < chars.length(); i++) {

            for (int k = 0; k < row; k++)
                for (int j = 0; j < col; j++) {
                    if (!field[k][j].character.isEmpty()) {
                        String s1 = field[k][j].getChars(), s2 = "";

                        for (int t = 0; t < usedChars.length(); t++) {

                            if (s1.contains("" + chars.charAt(t)))
                                s2 += 1;
                            else
                                s2 += 0;

                            if (t == usedChars.length() - 1)
                                s2 += Constants.NEXT_LINE;
                            else
                                s2 += '\\';

                        }

                        str[chars.indexOf(field[k][j].character)] = s2;

                    }
                }
        }

        String s = "";
        for (String s1 : str) {
            s += s1;
        }

        return s;
    }

    public class Line {

        float x, y;


        public Line(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }


    public class Field {
        public float x, y, textX, textY;
        public boolean circle = false, select = false;
        public String character = "";
        private String chars = "";
        public ArrayList<Line> line = new ArrayList<Line>();


        public Field(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public void add_char(String s) {
            chars += s + '.';
        }

        public void remove_char(String s) {
            StringBuilder stringBuilder = new StringBuilder(chars);

            stringBuilder.deleteCharAt(stringBuilder.indexOf(s));
            chars = stringBuilder.toString();
        }

        public void chars_reset() {
            chars = "";
        }

        public String getChars() {
            return chars;
        }
    }

}
