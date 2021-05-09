# I'll fucking credit myself again
# Config and refactoring by E404NNF
# Bot by Femboyhootersmanager

import random

import discord
import praw
from discord.ext import commands

import process_yaml

process_yaml = process_yaml.ProcessYaml
config = process_yaml.config

# commands prefix. will try to use / commands later
bot = commands.Bot(command_prefix='cp!')

# reddit sign in stuff
reddit = praw.Reddit(client_id=config['cwient_id'],
                     client_secret=config['cwient_secwet'],
                     username=config['usewname'],
                     password=config['passwewd'],
                     user_agent=config['usew_agent'])


@bot.command()
async def copypasta(ctx):
    subreddit = reddit.subreddit("copypasta")
    all_subs = []
    top = subreddit.top(limit=50)
    for submission in top:
        all_subs.append(submission)
    random_sub = random.choice(all_subs)
    name = random_sub.title
    url = random_sub.url
    body = random_sub.selftext
    em = discord.Embed(description=body, title=name, url=url)
    await ctx.send(embed=em)


bot.run(config['tewken'])
