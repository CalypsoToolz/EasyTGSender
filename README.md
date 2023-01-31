# EasyTGSender
Для начала необходимо узнать токен бота (пригласить бота в группу, затем получить токен у @BotFather)
```
private static final String BOT_TOKEN = "ПОЛУЧЕННЫЙ_ТОКЕН";
private static final Telegram tg = new Telegram(BOT_TOKEN);
```
теперь можно отправить сообщение:
```
tg.sendMessage("Some text\nNew line, "имя/ID канала");
```
