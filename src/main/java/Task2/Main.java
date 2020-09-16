package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        System.out.println("+N - прыгни на N шагов направо\n" +
                "-N - прыгни на N шагов налево\n" +
                "<< - Undo (отмени последнюю команду)\n" +
                ">> - Redo (повтори отменённую команду)\n" +
                "!! - повтори последнюю команду\n" +
                "0 - выход");
        int curCommand = -1;
        while (true) {
            //считываем ввод и конструируем комманду, если
            String in = sc.nextLine();
            //пользователь не хотел выйти
            if (in.matches("0")) break;

            if (in.matches("<<")) { /*пользователь хочет отменить действие*/
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (in.matches(">>")) { /*пользователь хочет повторить действие*/
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).go();
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (in.matches("[\\+\\-][0-9]+")) {
                    int steps = Integer.parseInt(in.replaceAll("[^0-9]", ""));

                    if (curCommand != commands.size() - 1) {
                        //удаляем все команды которые были отменены
                        commands = commands.stream().filter(c -> !c.isCanceled()).collect(Collectors.toList());
                        curCommand = commands.size() - 1;
                    }
                    FrogCommand cmd = in.matches("[\\-].*") ?
                            FrogCommands.jumpLeftCommand(frog, steps) :
                            FrogCommands.jumpRightCommand(frog, steps);
                    curCommand++;
                    commands.add(cmd);
                    cmd.go();
                } else {
                    System.out.println("Неопознанная команда");
                }
            }

            //рисуем поле после команды
            frog.printPosition();
        }
    }
}
