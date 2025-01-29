package com.btc.rwserver;

import com.btc.rwserver.Models.Robot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/robots")
public class Robots {
    private Robot[] robots;
    private List<String> usedUUIDs = new ArrayList<>();

    public Robots() {
        this.robots = new Robot[] {
                new Robot("some uuid", "idk whatever", 1, 1, 1, 1)
        };
    }

    @GetMapping
    public Robot[] getRobots() {
        return robots;
    }
}
