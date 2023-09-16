package org.hx.java.leetcode;

import java.util.Stack;

public class TwoStack {

    class CQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        // stack 1
        // stack 2
        public CQueue() {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if(!s2.isEmpty()) {
                return s2.pop();
            }

            revert();

            if(!s2.isEmpty()) {
                return s2.pop();
            }
            return -1;
        }

        private void revert() {
            if(!s1.isEmpty()) {
                while(!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }
}
