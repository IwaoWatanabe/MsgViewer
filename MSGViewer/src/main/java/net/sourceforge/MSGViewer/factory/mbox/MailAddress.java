package net.sourceforge.MSGViewer.factory.mbox;
/*
public record MailAddress(String displayName, String email) {

    @Override
    public String toString() {
        if (displayName == null)
            return email;

        return "\"" + displayName + "\"" + " <" + email + ">";
    }
}
/* */


import java.util.Objects;

public final class MailAddress {
    private final String displayName;
    private final String email;

    // 正規コンストラクタ（record は自動生成するが、class では自分で書く）
    public MailAddress(String displayName, String email) {
        this.displayName = displayName; // displayName は null を許容（元コードの判定に合わせる）
        this.email = email;             // email の必須チェックをしたい場合はここで行う
    }

    // アクセサ（record と同じく フィールド名() というアクセサ名を模倣）
    public String displayName() {
        return displayName;
    }

    public String email() {
        return email;
    }

    // equals / hashCode（record は成分全てを使うため、それに合わせる）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailAddress)) return false;
        MailAddress other = (MailAddress) o;
        return Objects.equals(this.displayName, other.displayName)
            && Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, email);
    }

    // toString（record のオーバーライドを忠実に再現）
    @Override
    public String toString() {
        if (displayName == null) {
            return email;
        }
        return "\"" + displayName + "\"" + " <" + email + ">";
    }
}

