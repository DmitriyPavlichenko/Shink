package com.shink;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UrlController {
    @GetMapping("/{url}")
    public String getUrl(@PathVariable String url) {
        if (UrlService.getUrl(url).isPresent()) {
            return "redirect:" + UrlService.getUrl(url).get().getUrl();
        } else {
            return null;
        }
    }

    @PostMapping
    @ResponseBody
    public String saveUrl(@RequestParam String url) {
        return UrlService.saveUrl(url);
    }
}
