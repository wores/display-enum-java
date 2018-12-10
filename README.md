# IDisplayEnum

マスタテーブルで管理するほどの量でもなく、
ビジネスライフサイクルに絡まない定数をenumで管理する時に、
DBに保存する値とフロントで使う表示名をいい感じに扱うenum用のインターフェイス

フロントでCheckBoxなどを使って定数一覧を表示するためのレスポンスを生成する時に個人的に有用だった

普段は自分のコードに自信はないが、これは良いDRYに仕上がっている自信がある

```java
import com.wores.interfaces.IDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Fruit implements IDisplayEnum<Fruit> {
    // ORANGEはDBに保存する定数名、オレンジはフロント側で表示する名前
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

js側ではこんな感じで使える(Vue.jsベース)
POSTする時にリクエストにkeyを入れて投げて、Java側はkeyを元にEnumに変換する流れ
```javascript
<ul class="form--choose">
    <li v-for="value, key in json">
        <input v-model="checkedFruits" type="checkbox" :name="key" :value="key" :id="key">
        <label :for="key" class="checkbox">{{ value }}</label>
    </li>
</ul>
```
