import yaml


class ProcessYaml:

    # We need to pre-define the config value
    config = []

    with open('config.yml', 'r') as file:
        try:
            # Load the config using yaml.safe_load()
            config = yaml.load(file)
            # Print the config for debugging purposes
            print('Loaded config successfully!')
            print(config)

        except yaml.YAMLError as exc:
            print(exc)
