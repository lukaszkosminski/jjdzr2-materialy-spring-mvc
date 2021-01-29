package pl.infoshare.springmvcpresentation.note;

import org.springframework.stereotype.Component;

@Component
public class NoteService {

    private Note inMemoryNote;

    public Note getNote() {
        return inMemoryNote;
    }

    public void save(Note note) {
        this.inMemoryNote = note;
    }


}
