
public class Stars {

	public void printStars(int x) {
		if (x >= 0) {
			for (int i = 0; i < x; i++) {
				System.out.print("*");
			}
		} else {

		}
	}

	public void printStarSquare(int x) {
		if (x >= 0) {
			for (int k = 0; k < x; k++) {
				for (int i = 0; i < x; i++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		} else {

		}
	}

	public void printStarTriangle(int x) {
		if (x >= 0) {
			for (int i = 0; i < x; i++) {
				for (int k = -1; k < i; k++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		} else {

		}
	}

	public void printStarInvertedTriangle(int x) {
		if (x >= 0) {
			for (int i = 0; i < x; i++) {
				for (int k = x - 1; k > i; k--) {
					System.out.print(" ");
				}
				for (int n = -1; n < i; n++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		} else {

		}
	}

	public void printStarPyramid(int x) {
		if (x >= 0) {
			for (int i = 0; i < x; i++) {
				for (int k = x - 1; k > i; k--) {
					System.out.print(" ");
				}
				for (int k = 0; k < i; k++) {
					System.out.print("*");
				}
				for (int k = -1; k < i; k++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		} else {

		}
	}

	public void printStarDiamond(int x) {
		if (x >= 0) {
			int ogX = x;
			x = Math.round(x / 2);
			if (ogX % 2 == 1) {
				for (int i = 0; i < x + 1; i++) {
					for (int k = x; k > i; k--) {
						System.out.print(" ");
					}
					for (int k = 0; k < i; k++) {
						System.out.print("*");
					}
					for (int n = -1; n < i; n++) {
						System.out.print("*");
					}
					System.out.println("");
				}
				for (int i = 0; i < x; i++) {
					for (int k = -1; k < i; k++) {
						System.out.print(" ");
					}
					for (int k = x; k > i; k--) {
						System.out.print("*");
					}
					for (int n = x - 1; n > i; n--) {
						System.out.print("*");
					}
					System.out.println("");
				}
			} else {
				for (int i = 0; i < x; i++) {
					for (int k = x - 1; k > i; k--) {
						System.out.print(" ");
					}
					for (int k = 0; k < i; k++) {
						System.out.print("*");
					}
					for (int n = -1; n < i; n++) {
						System.out.print("*");
					}
					System.out.println("");
				}
				for (int i = 0; i < x; i++) {
					for (int k = 0; k < i; k++) {
						System.out.print(" ");
					}
					for (int k = x; k > i; k--) {
						System.out.print("*");
					}
					for (int n = x - 1; n > i; n--) {
						System.out.print("*");
					}
					System.out.println("");
				}
			}
		} else {

		}
	}

	public void printStarHourGlass(int x) {
		if (x >= 0) {
			int ogX = x;
			boolean first = true;
			x = (int) (x / 2 + 0.5);
			if (ogX % 2 == 0) {
				for (int i = 0; i < x; i++) {
					for (int k = 0; k < i; k++) {
						System.out.print(" ");
					}
					for (int k = x; k > i; k--) {
						System.out.print("*");
					}
					for (int k = x - 1; k > i; k--) {
						System.out.print("*");
					}
					System.out.println("");
				}
				for (int i = 0; i < x; i++) {
					for (int k = x - 1; k > i; k--) {
						System.out.print(" ");
					}
					for (int k = 0; k < i; k++) {
						System.out.print("*");
					}
					for (int k = -1; k < i; k++) {
						System.out.print("*");
					}
					System.out.println("");
				}
			} else {
				for (int i = -1; i < x; i++) {
					for (int k = -1; k < i; k++) {
						System.out.print(" ");
					}
					for (int k = x; k > i; k--) {
						System.out.print("*");
					}
					for (int k = x - 1; k > i; k--) {
						System.out.print("*");
					}
					System.out.println("");
				}
				for (int i = 0; i < x + 1; i++) {
					if (!first) {
						for (int k = x; k > i; k--) {
							System.out.print(" ");
						}
						for (int k = 0; k < i; k++) {
							System.out.print("*");
						}
						for (int k = -1; k < i; k++) {
							System.out.print("*");
						}
						System.out.println("");
					}
					first = false;
				}
			}

		} else {

		}
	}

}
