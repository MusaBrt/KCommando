package me.koply.jdatest;

import me.koply.kcommando.integration.impl.jda.JDACommand;
import me.koply.kcommando.internal.Argument;
import me.koply.kcommando.internal.Commando;
import me.koply.kcommando.internal.KRunnable;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Commando(name = "Ping",
    aliases = "ping")
public class PingCommand extends JDACommand {
    public PingCommand() {
        getInfo().setOnFalseCallback((KRunnable<MessageReceivedEvent>) e -> e.getMessage().addReaction("⛔").queue());
    }

    @Override
    public boolean handle(MessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("Hello world").queue();
        return true;
    }

    @Argument(arg = "test")
    public boolean test(MessageReceivedEvent e) {
        e.getChannel().sendMessage("Ben test").queue();
        return true;
    }
}