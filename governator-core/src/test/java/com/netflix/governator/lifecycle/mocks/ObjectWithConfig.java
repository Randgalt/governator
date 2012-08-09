package com.netflix.governator.lifecycle.mocks;

import com.netflix.governator.annotations.Configuration;
import javax.validation.constraints.Min;
import java.util.Date;

public class ObjectWithConfig
{
    @Configuration("test.b")
    public boolean   aBool = false;

    @Configuration("test.i")
    public int       anInt = 1;

    @Configuration("test.l")
    public long      aLong = 2;

    @Configuration("test.d")
    public double    aDouble = 3.4;

    @Configuration("test.s")
    public String    aString = "test";

    @Configuration("test.dt")
    public Date     aDate = null;
}