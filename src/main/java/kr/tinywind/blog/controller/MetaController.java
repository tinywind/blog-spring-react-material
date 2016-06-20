package kr.tinywind.blog.controller;

import kr.tinywind.blog.model.BlogMeta;
import kr.tinywind.blog.model.BlogMetaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tinywind on 2016-06-20.
 */
@Controller
@RequestMapping("/!meta")
public class MetaController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MetaController.class);

    @Autowired
    private BlogMeta meta;

    @Autowired
    private BlogMetaRepository metaRepository;

    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String reqInit(Model model) {
        model.addAttribute("meta", meta);
        return "!meta/init";
    }

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String reqInit(BlogMeta meta) {
        BlogMeta blogMeta = metaRepository.saveAndFlush(meta);
        this.meta.set(blogMeta);
        return "redirect:/!meta/init";
    }
}