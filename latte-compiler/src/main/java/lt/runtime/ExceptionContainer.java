package lt.runtime;

import lt.lang.function.Function1;

import java.util.ArrayList;
import java.util.List;

/**
 * exception container
 */
public class ExceptionContainer {
        private List<String> exceptionMsgList = new ArrayList<String>();

        public void add(String msg) {
                exceptionMsgList.add(msg);
        }

        /**
         * throw if the exception message list is not empty
         *
         * @param msg head message
         * @param f   the function accepts a string of message and return an exception
         * @throws Throwable throwable
         */
        public void throwIfNotEmpty(String msg, Function1<Throwable, String> f) throws Throwable {
                if (exceptionMsgList.isEmpty()) return;

                StringBuilder sb = new StringBuilder();
                sb.append(msg);
                int count = 0;
                for (String tMsg : exceptionMsgList) {
                        String[] lines = tMsg.split("\\n");
                        boolean isFirst = true;
                        for (String line : lines) {
                                sb.append("\n\t");
                                if (isFirst) {
                                        isFirst = false;
                                        sb.append(++count).append(".").append(" ");
                                }
                                if (!line.trim().isEmpty()) {
                                        sb.append(line);
                                }
                        }
                }

                throw f.apply(sb.toString());
        }
}
