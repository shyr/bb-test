package com.magic

import net.bytebuddy.agent.builder.AgentBuilder
import net.bytebuddy.implementation.FixedValue
import net.bytebuddy.matcher.ElementMatchers
import java.lang.instrument.Instrumentation

class Magic

fun premain(agentStr: String?, inst: Instrumentation) {
    AgentBuilder.Default()
        .type(ElementMatchers.any())
        .transform { builder, _, _, _ ->
            builder.method(ElementMatchers.named("yaho"))
                .intercept(FixedValue.value("yaho... yaho... yaho..."))
        }.installOn(inst)
}