package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.FaceCard;
import models.Range;


public class CardManager {
	private int curMax = 0;
	ArrayList<FaceCard> cards = new ArrayList<FaceCard>();

	public CardManager(ArrayList<FaceCard> somecards) {
		for(int i=0;i<somecards.size();i++){
			curMax+=somecards.get(i).getPerformance();
		}
		double prev = 0;
		for (int i = 0; i < somecards.size(); i++) {
			Range myRange = new Range(prev, prev = prev
					+ somecards.get(i).getPerformance() / curMax);
			cards.add(somecards.get(i));
			cards.get(i).setRange(myRange);
		}
		Collections.sort(cards,new CompareByRangeStart());

	}

	public FaceCard getrandCard() {
		double rand = (Math.random());
		return getCardbyrand(rand, 0, cards.size() - 1);
	}

	public void update() {

		double prev = 0;

		for (int i = 0; i < cards.size(); i++) {
			Range myRange = new Range(prev, prev = prev
					+ cards.get(i).getPerformance() / curMax);
			cards.get(i).setRange(myRange);
		}
		Collections.sort(cards,new CompareByRangeStart());

	}

	public void addCard(FaceCard f) {

		cards.add(f);
		update();
		return;

	}

	public void removeCard(FaceCard f) {
		cards.remove(f);
		update();
		return;

	}

	public List<FaceCard> getAllCards() {
		return cards;
	}

	private FaceCard getCardbyrand(double rand, int first, int last)
	// retrive card by bin search
	{
		int mid = (first+last)/2;
		if (rand < cards.get(mid).getRange().getStart()) {
			return getCardbyrand(rand, 0, mid);
		}
		if (rand > cards.get(mid).getRange().getEnd()) {
			return getCardbyrand(rand, mid + 1, last);
		}
		return cards.get(mid);
	}

}
