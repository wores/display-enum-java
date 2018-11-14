package com.wores;

import com.wores.consts.Fruit;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class FruitTest {

    @Test
    public void shouldCreateCorrectMap() throws Exception {
        Map<String, String> map = Fruit.ORANGE.toMap();
        Arrays
            .asList(Fruit.values())
            .forEach(fruit -> {
                String displayName = map.get(fruit.name());
                Assert.assertThat(displayName, Is.is(fruit.getDisplayName()));
            });
    }

}
