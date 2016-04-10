package io.ipoli.android.quest.events;

import io.ipoli.android.quest.data.RecurrentQuest;

/**
 * Created by Polina Zhelyazkova <polina@ipoli.io>
 * on 4/9/16.
 */
public class DeleteRecurrentQuestEvent {
    public final RecurrentQuest recurrentQuest;

    public DeleteRecurrentQuestEvent(RecurrentQuest recurrentQuest) {
        this.recurrentQuest = recurrentQuest;
    }
}
