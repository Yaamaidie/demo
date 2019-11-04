import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

//值、过期时间的组合
public final class ValueWithExpires {
    //值
    private final String value;
    //过期时间，1970--现在的毫秒数
    private final long expires;

    public ValueWithExpires(String value, long expires) {
        this.value = value;
        this.expires = expires;
    }

    /**
     * 是否过期
     */
    public boolean isOverdue() {
        return System.currentTimeMillis() > expires;
    }

    public String getValue() {
        return value;
    }

    public long getExpires() {
        return expires;
    }

    /**
     * 删除中Map中过期的entry
     *
     * @param ValueWithExpiresMap 以valueWithExpires为value的Map
     */
    public static void removeOverdue(Map<?, ValueWithExpires> ValueWithExpiresMap) {
        Iterator<? extends Map.Entry<?, ValueWithExpires>> iter = ValueWithExpiresMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<?, ValueWithExpires> entry = iter.next();
            ValueWithExpires value = entry.getValue();
            if (value.isOverdue()) {
                iter.remove();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueWithExpires that = (ValueWithExpires) o;
        return expires == that.expires &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, expires);
    }

    @Override
    public String toString() {
        return "ValueWithExpires{" +
                "value='" + value + '\'' +
                ", expires=" + expires +
                '}';
    }

    public static void main(String[] args) {
        ValueWithExpires valueWithExpires = new ValueWithExpires("abc", System.currentTimeMillis());
        System.out.println(valueWithExpires);
    }
}