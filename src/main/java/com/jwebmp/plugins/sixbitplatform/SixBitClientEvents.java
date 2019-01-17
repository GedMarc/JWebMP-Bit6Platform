/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jwebmp.plugins.sixbitplatform;

/**
 * @author GedMarc
 * @since 22 Jun 2017
 */
public interface SixBitClientEvents
{

	void onCallAnswered();

	void onCallEnd();

	void onCallError();

	void onCallProgres();

	void onChatCreated();

	void onConnect();

	void onConversationChange();

	void onDisconnect();

	void onFileAttach();

	void onGroupChange();

	void onGroupCreated();

	void onGroupMemberAdded();

	void onGroupMemberRe();

	void onIncomingCall();

	void onLoginError();

	void onLoginSuccess();

	void onMessageChange();

	void onMessageSending();

	void onNotification();

	void onVideo();

}
