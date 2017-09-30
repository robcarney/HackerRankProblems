def string_permutations(my_string):
    """Returns all possible permutations of the given string in a list"""
    # For storing our list of string permutations
    result = []

    # If the string is of length 0, it's only permutation is the empty string
    if len(my_string) == 0:
        result.append(my_string)
        return result

    # For each character in the string...
    for character in list(my_string):
        # Append it to the front of all permutations of the string excluding that character...
        current_list = string_permutations(my_string.replace(character, "", 1))
        for perm in current_list:
            # And add all such strings to the result list
            result.append(character + perm)
    return result

# Run on unix terminal with command:
#      python string_permutations.py %INPUT_STRING%
if __name__ == "__main__":
    from sys import argv
    try:
        input_string = argv[1]
        for word in string_permutations(input_string):
            print(word)
    except:
        print("Something went wrong with the script. Please ensure the input arguments are formatted correctly.")

