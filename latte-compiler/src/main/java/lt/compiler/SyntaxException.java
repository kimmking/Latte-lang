/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 KuiGang Wang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package lt.compiler;

/**
 * wrong syntax
 */
public class SyntaxException extends CompileException {
        public final LineCol lineCol;
        public final String msg;
        public final String lineMsg;

        public SyntaxException(String lineMsg, String msg, LineCol lineCol) {
                super(lineMsg + msg +
                        (lineCol == LineCol.SYNTHETIC
                                ? ""
                                : (" at " + lineCol.fileName + "(" + lineCol.line + "," + lineCol.column + ")")) +
                        (lineCol.useDefine.isEmpty()
                                ? ""
                                : "\nThis line uses defined replacement (" + lineCol.useDefine + "), the column might not be precise"));
                this.lineMsg = lineMsg;
                this.msg = msg;
                this.lineCol = lineCol;
        }
}
