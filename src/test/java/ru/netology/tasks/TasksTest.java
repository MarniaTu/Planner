package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchQueryByOneWordSimpleTasks() {
        SimpleTask simpleTask = new SimpleTask(10, "Забрать телефон из ремонта");

        simpleTask.matches("ремонт");

        boolean expected = true;
        boolean actual = simpleTask.matches("ремонт");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryByAnotherOneWordSimpleTasks() {
        SimpleTask simpleTask = new SimpleTask(10, "Забрать телефон из ремонта");


        simpleTask.matches("телефон");

        boolean expected = true;
        boolean actual = simpleTask.matches("телефон");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchQuerySimpleTasksMissingWord() {
        SimpleTask simpleTask = new SimpleTask(10, "Забрать телефон из ремонта");


        simpleTask.matches("мастерская");

        boolean expected = false;
        boolean actual = simpleTask.matches("мастерская");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryByPartOfWordSimpleTasks() {
        SimpleTask simpleTask = new SimpleTask(10, "Забрать телефон из ремонта");


        simpleTask.matches("тел");

        boolean expected = true;
        boolean actual = simpleTask.matches("тел");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchQueryByUpperCaseWordSimpleTasks() {
        SimpleTask simpleTask = new SimpleTask(10, "Забрать телефон из ремонта");


        simpleTask.matches("Тел");

        boolean expected = false;
        boolean actual = simpleTask.matches("Тел");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQuerySubTasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Подарки НГ", "Аптека"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("Подарки");

        boolean expected = true;
        boolean actual = epic.matches("Подарки");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchQuerySubTasksMissingWord() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Подарки НГ", "Аптека"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("конфеты");
        boolean expected = false;
        boolean actual = epic.matches("конфеты");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQuerySubTasksPartOfWord() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Подарки НГ", "Аптека"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("Мол");
        boolean expected = true;
        boolean actual = epic.matches("Мол");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchQuerySubTasksLowerCase() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Подарки НГ", "Аптека"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("аптека");
        boolean expected = false;
        boolean actual = epic.matches("аптека");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchQueryMeetingInTopic() {

        Meeting meeting = new Meeting(557, "Повторное тестирование после фиксов", "Приложение НетоБанка", "Согласовать как можно раньше");

        meeting.matches("фикс");

        boolean expected = true;
        boolean actual = meeting.matches("фикс");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotMatchQueryMeetingInTopic() {

        Meeting meeting = new Meeting(557, "Повторное тестирование после фиксов", "Приложение НетоБанка", "Согласовать как можно раньше");

        meeting.matches("повтор тестов");

        boolean expected = false;
        boolean actual = meeting.matches("повтор тестов");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchQueryMeetingInProject() {

        Meeting meeting = new Meeting(557, "Повторное тестирование после фиксов", "Приложение НетоБанка", "Согласовать как можно раньше");

        meeting.matches("Нето");

        boolean expected = true;
        boolean actual = meeting.matches("Нето");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotMatchQueryMeetingInProjectLowerCase() {

        Meeting meeting = new Meeting(557, "Повторное тестирование после фиксов", "Приложение НетоБанка", "Согласовать как можно раньше");

        meeting.matches("нето");

        boolean expected = false;
        boolean actual = meeting.matches("нето");
        Assertions.assertEquals(expected, actual);

    }

}
