
package com.example.sieunhan.github_client.core.user;

import android.accounts.Account;
import android.content.Context;
import android.util.Log;

import com.github.mobile.R;
import com.github.mobile.ui.ProgressDialogTask;
import com.google.inject.Inject;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.UserService;

/**
 * Task to unfollow a user
 */
public class UnfollowUserTask extends ProgressDialogTask<User> {

    private static final String TAG = "UnfollowUserTask";

    @Inject
    private UserService service;

    private final String login;

    /**
     * Create task for context and login
     *
     * @param context
     * @param login
     */
    public UnfollowUserTask(final Context context, final String login) {
        super(context);

        this.login = login;
    }

    /**
     * Execute the task with a progress dialog displaying.
     * <p>
     * This method must be called from the main thread.
     */
    public void start() {
        showIndeterminate(R.string.unfollowing_user);

        execute();
    }

    @Override
    protected User run(final Account account) throws Exception {
        service.unfollow(login);

        return null;
    }

    @Override
    protected void onException(final Exception e) throws RuntimeException {
        super.onException(e);

        Log.d(TAG, "Exception unfollowing user", e);
    }
}
