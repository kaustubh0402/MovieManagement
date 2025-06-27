package org.example.services.cacheService.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.Movie;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class movieNode extends DLLNode {
    private Movie movie;
    private movieNode next;
    private movieNode prev;
}
