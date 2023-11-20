import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PluginTranslator extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);
        String SelectedText = editor.getSelectionModel().getSelectedText();
        String language = "en";
        if (SelectedText == null) {
            BrowserUtil.browse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        }
        else {
            String encoded = "";
            encoded = URLEncoder.encode(SelectedText, StandardCharsets.UTF_8);
            for (char symbol : SelectedText.toCharArray()) {
                if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z')) {
                    language = "ru";
                    break;
                }
            }

            String url = String.format("https://translate.google.co.jp/?hl=en&sl=auto&tl=%s&text=%s&op=translate", language, encoded);
            BrowserUtil.browse(url);
        }
        }
    }