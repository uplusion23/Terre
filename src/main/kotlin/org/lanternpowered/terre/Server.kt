/*
 * Terre
 *
 * Copyright (c) LanternPowered <https://www.lanternpowered.org>
 * Copyright (c) contributors
 *
 * This work is licensed under the terms of the MIT License (MIT). For
 * a copy, see 'LICENSE.txt' or <https://opensource.org/licenses/MIT>.
 */
package org.lanternpowered.terre

import org.lanternpowered.terre.text.MessageReceiver
import org.lanternpowered.terre.text.Text

/**
 * Represents a server that the proxy knows about.
 */
interface Server : MessageReceiver {

  /**
   * The server info of this server.
   */
  val info: ServerInfo

  /**
   * All the players that are currently connected to this
   * server.
   */
  val players: PlayerCollection

  /**
   * Whether players are allowed to automatically join this
   * server when they initially connect or after evacuating
   * a server.
   */
  var allowAutoJoin: Boolean

  /**
   * Unregisters this [Server]. This doesn't move [Player]s
   * from this server or disconnects them, this should be
   * handled by the caller.
   */
  fun unregister()

  /**
   * Evacuates all the [Player]s from this server. The proxy will
   * attempt to redirect them to another possible server.
   */
  fun evacuate()

  /**
   * Broadcasts the message to all the [Player]s on this
   * server.
   */
  override fun sendMessage(message: String)

  /**
   * Broadcasts the text message to all the [Player]s on
   * this server.
   */
  override fun sendMessage(message: Text)

  /**
   * Broadcasts the text message to all the [Player]s on
   * this as if it was send by the given [MessageSender].
   *
   * This will prepend '<sender>' to the message, where
   * sender is the name of the sender.
   *
   * If the sender and receiver are on the same server
   * and within visible range the receiver will see a
   * chat balloon above the sender' head.
   */
  override fun sendMessageAs(message: Text, sender: MessageSender)

  /**
   * Broadcasts the message to all the [Player]s on
   * this as if it was send by the given [MessageSender].
   *
   * This will prepend '<sender>' to the message, where
   * sender is the name of the sender.
   *
   * If the sender and receiver are on the same server
   * and within visible range the receiver will see a
   * chat balloon above the sender' head.
   */
  override fun sendMessageAs(message: String, sender: MessageSender)
}
