
import json
import tkinter, tkinter.messagebox


def main():

    # Read the quotes DB.
    with open("../db.json") as db:
        quotes = json.load(db)

    size = len(quotes)

    # Get the user's index
    index = 0
    while index < 1 or index > size:
        index = int(input(f"Enter the quote index (1..{size}) : "))

    quote = quotes[str(index)]
    root = tkinter.Tk()
    root.withdraw()
    tkinter.messagebox.showinfo("AE once said ...", quote)
    root.destroy()


if __name__ == '__main__':
    main()
