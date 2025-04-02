package dev.redshadow.stickynotes.interfaces;

import dev.redshadow.stickynotes.entities.Stickynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StickyNoteRepository extends JpaRepository<Stickynote, String> {
}
