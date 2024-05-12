package es.bogaservic.backendTOP.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class InputLineItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iInputLineId;
	private int InjectedItems;
	private int CullingRejectOld;
	private int MailpieceAppeared;
	private int OutOfSlotTooLate;
	private int SlotTooEarly;
	private int InjectableCollision;
	private int UnInjectableCollision;
	private int TooThick;
	private int TooHigh;
	private int TooLong;
	private int TooShort;
	private int UnavailableBucket;
	private int TooCloseToCulledItem;
	private int CullingReject;

	public InputLineItem() {
		super();
	}

	public InputLineItem(int iInputLineId, int injectedItems, int cullingRejectOld, int mailpieceAppeared,
			int outOfSlotTooLate, int slotTooEarly, int injectableCollision, int unInjectableCollision, int tooThick,
			int tooHigh, int tooLong, int tooShort, int unavailableBucket, int tooCloseToCulledItem, int cullingReject) {
		super();
		this.iInputLineId = iInputLineId;
		InjectedItems = injectedItems;
		CullingRejectOld = cullingRejectOld;
		MailpieceAppeared = mailpieceAppeared;
		OutOfSlotTooLate = outOfSlotTooLate;
		SlotTooEarly = slotTooEarly;
		InjectableCollision = injectableCollision;
		UnInjectableCollision = unInjectableCollision;
		TooThick = tooThick;
		TooHigh = tooHigh;
		TooLong = tooLong;
		TooShort = tooShort;
		UnavailableBucket = unavailableBucket;
		TooCloseToCulledItem = tooCloseToCulledItem;
		CullingReject = cullingReject;
	}


}
