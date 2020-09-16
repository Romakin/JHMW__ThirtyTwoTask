package Task2;

public class FrogCommands {

    public static FrogCommand jumpRightCommand(final Frog frog, final int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return getCmd(frog, steps, true);
    }

    public static FrogCommand jumpLeftCommand(final Frog frog, final int steps) {
        return getCmd(frog, steps, false);
    }

    private static FrogCommand getCmd(final Frog frog, final int steps, final boolean isRightDirection) {
        return new FrogCommand() {
            int cmdStat = 0;
            public boolean go() {
                if (frog.jump(steps * (isRightDirection ? 1 : -1))) {
                    cmdStat = 1;
                    return true;
                }
                System.out.println(":(");
                return false;
            }

            public boolean undo() {
                if (cmdStat == 1)
                    if (frog.jump(steps * (isRightDirection ? -1 : 1))) {
                        cmdStat= -1;
                        return true;
                    }
                System.out.println(":(");
                return false;
            }
            public boolean isCanceled() { return cmdStat <= 0; }
        };
    }

}
