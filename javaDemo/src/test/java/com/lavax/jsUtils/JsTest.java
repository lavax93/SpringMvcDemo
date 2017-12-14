package com.lavax.jsUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by LAVAX on 2017/11/16.
 */
public class JsTest {
    @Test
    public void Test() {
        IAdd add = JsProxyFactory.newInstance(IAdd.class, "num1+num2");
        int result = add.add(1, 99);
        Assert.assertEquals(100, result);
        System.out.println(result);
    }
}
