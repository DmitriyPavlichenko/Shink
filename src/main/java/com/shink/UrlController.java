package com.shink;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("{url}")
    public String getUrl(@PathVariable String url) {
        return "redirect:" + urlService.getUrl(url);
    }

    @PostMapping
    @ResponseBody
    public String saveUrl(@RequestParam String url) {
        return urlService.saveUrl(url);
    }
}
