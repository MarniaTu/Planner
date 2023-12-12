package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksByPartOfWord() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Найти ремонт телефона");
        SimpleTask simpleTask2 = new SimpleTask(7, "Забрать телефон из ремонта");

        String[] subtasks = {"Молоко", "Яйца", "тесто", "Подарки"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(555, "Повтор тестов 3й версии приложения", "Приложение НетоБанка", "Утро понедельника");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting1);
        todos.add(meeting2);

        todos.search("те");

        Task[] expected = {simpleTask1, simpleTask2, epic, meeting2};
        Task[] actual = todos.search("те");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksByOneWord() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Найти ремонт телефона");
        SimpleTask simpleTask2 = new SimpleTask(7, "Забрать телефон из ремонта");

        String[] subtasks = {"Молоко", "Яйца", "тесто", "Подарки"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(555, "Повтор тестов 3й версии приложения", "Приложение НетоБанка", "Утро понедельника");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting1);
        todos.add(meeting2);

        todos.search("тест");

        Task[] expected = {epic, meeting2};
        Task[] actual = todos.search("тест");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksByFigure() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Найти ремонт телефона");
        SimpleTask simpleTask2 = new SimpleTask(7, "Забрать телефон из ремонта");

        String[] subtasks = {"Молоко", "Яйца", "тесто", "Подарки"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(555, "Повтор тестов 3й версии приложения", "Приложение НетоБанка", "Утро понедельника");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting1);
        todos.add(meeting2);

        todos.search("3");

        Task[] expected = {meeting1, meeting2};
        Task[] actual = todos.search("3");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTasksByWordInDifferentCase() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Найти ремонт телефона");
        SimpleTask simpleTask2 = new SimpleTask(7, "Забрать телефон из ремонта");

        String[] subtasks = {"Молоко", "Яйца", "тесто", "Подарки"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(555, "Повтор тестов 3й версии приложения", "Приложение НетоБанка", "Утро понедельника");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting1);
        todos.add(meeting2);

        todos.search("Тел");

        Task[] expected = {};
        Task[] actual = todos.search("Тел");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTasksByWordInDifferentLanguage() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Найти ремонт телефона");
        SimpleTask simpleTask2 = new SimpleTask(7, "Забрать телефон из ремонта");

        String[] subtasks = {"Молоко", "Яйца", "тесто", "Подарки"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(555, "Повтор тестов 3й версии приложения", "Приложение НетоБанка", "Утро понедельника");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting1);
        todos.add(meeting2);

        todos.search("test");

        Task[] expected = {};
        Task[] actual = todos.search("test");
        Assertions.assertArrayEquals(expected, actual);
    }

}
