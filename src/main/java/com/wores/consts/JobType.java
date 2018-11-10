package com.wores.consts;

import com.wores.interfaces.IDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum JobType implements IDisplayEnum<JobType> {

    ENGINEER(1, "エンジニア"),
    MARKETING(2, "マーケティング"),
    DESIGNER(3, "デザイナー"),
    PM(4, "プロジェクトマネージャー"),
    ;

    @Getter
    private long id;

    @Getter
    private String displayName;

}
