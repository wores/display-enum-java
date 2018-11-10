# IDisplayEnum

マスタテーブルで管理するほどの量でもなく、不変である定数をenumで管理する時に、DBに保存する定数とフロントで使う表示名をいい感じに扱うenum用のインターフェイス

フロントでCheckBoxなどを使って定数一覧を表示するためのレスポンスを生成する時に個人的に有用だった



```java
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
```

```java
// 定数を挟まないといけないところがイケてない
systemp.out.println(Fruit.ORANGE.toMap());
// → {ORANGE=オレンジ, APPLE=林檎, MELON=メロン}
```

