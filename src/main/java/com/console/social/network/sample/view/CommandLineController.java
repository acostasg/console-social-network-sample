package com.console.social.network.sample.view;

import com.console.social.network.sample.view.controller.ReaderController;
import com.console.social.network.sample.view.controller.WallController;
import org.springframework.stereotype.Component;
import com.console.social.network.sample.view.controller.PostController;
import com.console.social.network.sample.view.controller.FollowingController;

@Component
public class CommandLineController {

    private final ReaderController readerController;
    private final WallController wallController;
    private final PostController postController;
    private final FollowingController followingController;

    public CommandLineController(
            ReaderController readerController,
            WallController wallController,
            PostController postController,
            FollowingController followingController
    ) {
        this.readerController = readerController;
        this.wallController = wallController;
        this.postController = postController;
        this.followingController = followingController;
    }

    public void __call(String[] commandWords) throws Exception {

        if (commandWords.length == 1) {
            this.readerController.__call(commandWords);
        } else if (commandWords.length == 2 && commandWords[1].equals("wall")) {
            this.wallController.__call(commandWords);
        } else if (commandWords.length > 1 && commandWords[1].equals("->")) {
            this.postController.__call(commandWords);
        } else if (commandWords.length == 3 && commandWords[1].equals("follows")) {
            this.followingController.__call(commandWords);
        } else {
            throw new Exception("Command not found");
        }
    }
}
