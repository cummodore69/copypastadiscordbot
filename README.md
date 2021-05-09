# copypastadiscordbot
Our shitty attempt at making a discord bot that gets a random submission from r/copypasta

## Setting up
  <details open>
  <summary>Java</summary>
  
   -  In `me.e404nnf.copypastadiscordbot.Main` replace `<DISCORD_TOKEN>` with your Discord bot token.
   -  In `me.e404nnf.copypastadiscordbot.reddit.Reddit` replace `<APP_ID>` with your Reddit app ID, replace `<USERNAME>` with your reddit username, replace `<PASSWORD>` with your reddit password, replace `<CLIENT_ID>` and `<CLIENT_SECRET>` with your OAuth application's Client ID and Client secret.

  </details>

  <details open>
  <summary>Python</summary>
  
  - Literally just check the `config.yml` file, all the info is included in it
 
  </details>
  
### Optional changes
#### The steps below are optional to do
  <details open>
  <summary>Java</summary>
  
   -  In `me.e404nnf.copypastadiscordbot.reddit.Reddit` replace `copypasta` (Line 30) with your desired subreddit.
   -  In `me.e404nnf.copypastadiscordbot.discord.events.CopypastaCommand` replace `cp!copypasta` with your desired command.

  </details>
  
  <details open>
  <summary>Python</summary>
  
  - In `copypastabot.py` replace `cp!` (Line 16) with your desired prefix.
  - In `copypasta.py` replace `copypasta` (Line 28) with your desired command.

  </details>
