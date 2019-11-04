package javaConcurrencePractice.ch2;

/**
 * 延迟初始化中的竞态条件（race condition）
 */
public class LazyInitRace {
    private ExpensiiveObject instance = null;

    public ExpensiiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiiveObject();
        }
        return instance;
    }
}

/**
 * 昂贵的对象（如数据库连接）
 */
class ExpensiiveObject {

}
