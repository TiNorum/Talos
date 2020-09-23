package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;


public class PlaceholderFragment_Task_1442 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1442 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1442 fragment = new PlaceholderFragment_Task_1442();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    private Button button_answer;
    private TextView text_answer;
    private EditText number, count_number, find_first, find_second, find_if, replace, replace_yes, replace_else, replace_no;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_task_1442, container, false);

        // находим кнопку с которой работает
        button_answer = root.findViewById(R.id.task1442_btn_answer);
        button_answer.setOnClickListener(oclBtn);

        number = root.findViewById(R.id.edittext_number);
        find_first = root.findViewById(R.id.edittext_find_first);
        find_second = root.findViewById(R.id.edittext_find_second);
        find_if = root.findViewById(R.id.edittext_find_if);
        replace = root.findViewById(R.id.edittext_replace);
        replace_yes = root.findViewById(R.id.edittext_replace_yes);
        replace_else = root.findViewById(R.id.edittext_replace_else);
        replace_no = root.findViewById(R.id.edittext_replace_no);
        count_number = root.findViewById(R.id.edittext_count_number);

        text_answer = root.findViewById(R.id.task1442_textview_answer);
        return root;
    }

    private View.OnClickListener oclBtn = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (checkData()) return;

            String data = getData();

            Toast toast = Toast.makeText(getContext(),
                    data, Toast.LENGTH_SHORT);
            toast.show();
            //отправка на сервер
            //*****************
            //*****************
            ///////////////////

            text_answer.setVisibility(View.VISIBLE);
        }

        private String getData()
        {
            String data = "100" + Constants.NEXT_LINE + "42" + Constants.NEXT_LINE;
            data += number.getText().toString() + Constants.NEXT_LINE;
            data += count_number.getText().toString() + Constants.NEXT_LINE;
            data += find_if.getText().toString() + Constants.NEXT_LINE;
            data += replace_yes.getText().toString() + Constants.NEXT_LINE;
            data += replace_no.getText().toString();

            return data;
        }

        private boolean checkData()
        {
            if (number.getText().toString().isEmpty())
            {
                ShowToast.showToast(getContext(), "Введите из каких цифр состоит строка!");
                return true;
            }
            else if (count_number.getText().toString().isEmpty())
            {
                ShowToast.showToast(getContext(), "Введите количество цифр из которых состоит строка!");
                return true;
            }
            else if (Integer.parseInt(count_number.getText().toString()) == 0)
            {
                ShowToast.showToast(getContext(), "Строка не может состоять из 0 цифр. Введите значение для количества цифр не равное 0!");
                return true;
            }
            else if (find_first.length() != 3  || find_second.length() != 3)
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. ПОКА нашлось () — это условие должно состоять из 3-ёх цифр!");
                return true;
            }
            else if (find_if.length() != 3)
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. ПОКА нашлось () — это условие должно состоять из 3-ёх цифр!");
                return true;
            }
            else if (replace.length() != 3)
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. ТО заменить (____,  ) — первая часть скобки должна состоять из 3-ёх цифр!");
                return true;
            }
            else if (replace_else.length() != 3)
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. ИНАЧЕ заменить (____,  ) — первая часть скобки должна состоять из 3-ёх цифр!");
                return true;
            }
            else if (find_first.getText().toString().equals(find_second.getText().toString()))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Первое и второе условия в ПОКА не должны совпадать!");
                return true;
            }
            else if (!find_first.getText().toString().equals(find_if.getText().toString()) || !find_second.getText().toString().equals(find_if.getText().toString()))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Условия в первых двух строчках не совпадают, все цифры разные!");
                return true;
            }
            else if (!find_first.getText().toString().equals(replace_else.getText().toString()) || !find_second.getText().toString().equals(replace_else.getText().toString()))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Условия в ПОКА() и ИНАЧЕ () не совпадают!");
                return true;
            }
            else if (!find_if.getText().toString().equals(replace.getText().toString()))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Условия в ЕСЛИ не совпадает с условием в ЗАМЕНИТЬ, все цифры разные!");
                return true;
            }
            else if (find_first.getText().toString().charAt(0) != replace_yes.getText().toString().charAt(0)  || find_second.getText().toString().charAt(0) != replace_yes.getText().toString().charAt(0))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Условия в ТО заменить ().");
                return true;
            }
            else if (find_first.getText().toString().charAt(0) != replace_no.getText().toString().charAt(0)  || find_second.getText().toString().charAt(0) != replace_no.getText().toString().charAt(0))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Условия в ИНАЧЕ заменить ().");
                return true;
            }
            else if (replace_yes.getText().toString().equals(replace_no.getText().toString()))
            {
                ShowToast.showToast(getContext(), "Проверьте введённые данные. Условия в ТО заменить () и ИНАЧЕ заменить().");
                return true;
            }
            else if (find_first.getText().toString().isEmpty() || find_second.getText().toString().isEmpty() || find_if.getText().toString().isEmpty() ||
                    replace.getText().toString().isEmpty() || replace_yes.getText().toString().isEmpty() || replace_else.getText().toString().isEmpty() || replace_no.getText().toString().isEmpty())
            {
                ShowToast.showToast(getContext(), "Заполните все параметры!");
                return true;
            }

            return false;
        }
    };
}

