package com.zorba.study.bytecode.manipulate;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Magician {

    /**
     *
     * @see <a href="https://baeldung.com/byte-buddy">baeldung.com/byte-buddy</a>
     * */
    public static void main(String[] args) {
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(Hat.class)
                .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                .make()
                .load(Hat.class.getClassLoader(),
                        ClassReloadingStrategy.fromInstalledAgent());

        System.out.println(new Hat().pullOut());
    }

}
