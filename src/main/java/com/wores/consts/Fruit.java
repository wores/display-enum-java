package com.wores.consts;

import com.wores.interfaces.IDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Fruit implements IDisplayEnum<Fruit> {

    ORANGE("オレンジ"),
    APPLE("林檎"),
    MELON("メロン"),
    ;

    @Getter
    private String displayName;

}

