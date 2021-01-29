package pl.infoshare.springmvcpresentation.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/note-details")
    public String displayNoteDetails(Model model) {
        Note exampleNote = noteService.getNote();

        model.addAttribute("note", exampleNote);

        return "note-details-view";
    }

    @GetMapping("/create-note-details")
    public String displayCreateNoteDetails(Model model) {
        model.addAttribute("note", new Note());

        return "create-note-details-view";
    }

    @PostMapping("/note-details")
    public String createNoteDetails(@ModelAttribute Note note, Model model) {
        noteService.save(note);
        model.addAttribute("note", note);

        return "note-details-view";
    }
}
