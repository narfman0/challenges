from setuptools import setup, find_packages


setup(
    name='challenges-algorithms',
    version='0.1.0',
    description=('Testing out algorithm stuff, havent done this for years!'),
    classifiers=[
        'Development Status :: 4 - Beta',
        'License :: OSI Approved :: GNU General Public License v3 (GPLv3)',
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Topic :: Software Development :: Libraries :: Python Modules'],
    keywords='algorithm algorithms',
    author='Jon Robison',
    author_email='narfman0@gmail.com',
    url='https://github.com/narfman0/challenges/algorithms',
    license='LICENSE',
    packages=find_packages(),
    include_package_data=True,
    zip_safe=True,
    install_requires=[],
    test_suite='tests',
)
