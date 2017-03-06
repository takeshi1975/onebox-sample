package es.onebox.rest.utils.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

/**
 * Utility class that has methods used throughout the application.
 * @author Oreste Luci
 */
@Component
public class AppUtils {

    public static String FLASH_KIND_KEY = "flashKind";
    public static String FLASH_MESSAGE_KEY = "flashMessage";

    private static MessageSource messageSource;

    @Autowired
    public AppUtils(MessageSource messageSource) {
        AppUtils.messageSource = messageSource;
    }

    /**
     * Adds attributed to the model given the message kind and message key to be displayed in the view.
     *
     * @param model
     * @param kind
     * @param messageKey
     */
    public static void flash(Model model, String kind, String messageKey) {
        model.addAttribute(AppUtils.FLASH_KIND_KEY, kind);
        model.addAttribute(AppUtils.FLASH_MESSAGE_KEY,AppUtils.getMessage(messageKey));
    }

    /**
     * Adds attributed to the RedirectAttributes given the message kind and message key to be displayed in the view.
     *
     * @param redirectAttributes
     * @param kind
     * @param messageKey
     */
    public static void flash(RedirectAttributes redirectAttributes, String kind, String messageKey) {
        redirectAttributes.addFlashAttribute("flashKind",kind);
        redirectAttributes.addFlashAttribute("flashMessage",AppUtils.getMessage(messageKey));
    }

    /**
     * Returns a message in the properties file given its key.
     *
     * @param messageKey
     * @param args
     * @return
     */
    public static String getMessage(String messageKey, Object... args) {
        if (messageSource == null) {
            return "Internal Error: No Message Bundle Configured!";
        }
        return messageSource.getMessage(messageKey,args, Locale.getDefault());
    }
}
