package javaConcurrencePractice.ch4;

import annotation.GuardedBy;
import annotation.ThreadSafe;
import javaConcurrencePractice.bean.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过封闭机制来确保线程安全性
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

}
