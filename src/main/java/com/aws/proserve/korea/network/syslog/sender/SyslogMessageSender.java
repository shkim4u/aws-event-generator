/*
 * Copyright 2010-2014, CloudBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aws.proserve.korea.network.syslog.sender;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import com.aws.proserve.korea.network.syslog.MessageFormat;
import com.aws.proserve.korea.network.syslog.SyslogMessage;

/**
 * Send messages to a Syslog server.
 *
 * Implementation <strong>MUST</strong> be thread safe.
 *
 * @author <a href="mailto:cleclerc@cloudbees.com">Cyrille Le Clerc</a>
 */
//@ThreadSafe
public interface SyslogMessageSender {
    public static final long DEFAULT_INET_ADDRESS_TTL_IN_MILLIS = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
    public static final long DEFAULT_INET_ADDRESS_TTL_IN_NANOS = TimeUnit.NANOSECONDS.convert(DEFAULT_INET_ADDRESS_TTL_IN_MILLIS, TimeUnit.MILLISECONDS);
    public static final String DEFAULT_SYSLOG_HOST = "localhost";
    public static final MessageFormat DEFAULT_SYSLOG_MESSAGE_FORMAT = MessageFormat.RFC_3164;
    public static final int DEFAULT_SYSLOG_PORT = 514;

    /**
     * Send the given message ; the Syslog fields (appName, severity, priority, hostname ...) are the default values
     * of the {@linkplain com.aws.proserve.korea.network.syslog.sender.SyslogMessageSender MessageSender}.
     *
     * @param message the message to send
     * @throws IOException
     */
    void sendMessage(CharArrayWriter message) throws IOException;

    /**
     * Send the given message ; the Syslog fields (appName, severity, priority, hostname ...) are the default values
     * of the {@linkplain com.aws.proserve.korea.network.syslog.sender.SyslogMessageSender MessageSender}.
     *
     * @param message the message to send
     * @throws IOException
     */
    void sendMessage(CharSequence message) throws IOException;

    /**
     * Send the given {@link com.aws.proserve.korea.network.syslog.SyslogMessage}.
     *
     * @param message the message to send
     * @throws IOException
     */
    void sendMessage(SyslogMessage message) throws IOException;

	void close();
}
