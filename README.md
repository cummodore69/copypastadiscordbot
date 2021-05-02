# copypastadiscordbot
My shitty attempt at making a discord bot that gets a random submission from r/copypasta

## Setting up
- In `me.e404nnf.copypastadiscordbot.Main` replace `<DISCORD_TOKEN>` with your Discord bot token.
- In `me.e404nnf.copypastadiscordbot.reddit.Reddit` replace `<APP_ID>` with your Reddit app ID, replace `<USERNAME>` with your reddit username, replace `<PASSWORD>` with your reddit password, replace `<CLIENT_ID>` and `<CLIENT_SECRET>` with your OAuth application's Client ID and Client secret.
### Optional changes:
#### The steps below are optional to change:
- In `me.e404nnf.copypastadiscordbot.reddit.Reddit` replace `copypasta` (Line 30) with your desired subreddit.
- In `me.e404nnf.copypastadiscordbot.discord.events.CopypastaCommand` replace `cp!copypasta` with your desired command.
