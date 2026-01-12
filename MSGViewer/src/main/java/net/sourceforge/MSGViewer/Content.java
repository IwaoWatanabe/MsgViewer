package net.sourceforge.MSGViewer;

/* 
record Content(String type, String text) {
}
/* */

import java.util.Objects;

public final class Content {
    private final String type;
    private final String text;

    // 正規コンストラクタ（null チェックなどは record では自動ではないので、必要なら自分で書く）
    public Content(String type, String text) {
        this.type = type;
        this.text = text;
    }

    // アクセサ（record は getXxx ではなく フィールド名() になります）
    public String type() {
        return type;
    }

    public String text() {
        return text;
    }

    // equals と hashCode（フィールド全てを比較・計算）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;
        Content other = (Content) o;
        return Objects.equals(this.type, other.type)
            && Objects.equals(this.text, other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, text);
    }

    // toString（record は "Content[type=..., text=...]" のような形式）
    @Override
    public String toString() {
        return "Content[type=" + type + ", text=" + text + "]";
    }
}
