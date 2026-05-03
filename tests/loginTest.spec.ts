import { test } from '@playwright/test'
import { LoginPage } from '../Pages/LoginPage';
import login_Dynamic from '../test-data/login_Dynamic.json';

login_Dynamic.forEach((data) => {
    if (!data.run) return;

    test(`Login Test with ${data.username} and ${data.password}`, async ({ page }) => {
        const loginPage = new LoginPage(page);
        await loginPage.goToLoginPage();
        await loginPage.login(data.username, data.password);
        if (data.expected === 'success') {
            await loginPage.verifyLoginSuccess();
        } else {
            await loginPage.verifyLoginFailure();
        }
    });
});


