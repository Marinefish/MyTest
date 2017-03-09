package com.fang.dailytask;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/9
 * Time: 23:31
 */
public class WordsReverseTest {
    @Test
    public void reverse() throws Exception {
        WordsReverse wordsReverse = new WordsReverse();
        assertEquals("blue is sky the",wordsReverse.reverse("the sky is blue"));
        assertEquals("1",wordsReverse.reverse("1 "));
        assertEquals("1",wordsReverse.reverse("   1 "));
    }

}