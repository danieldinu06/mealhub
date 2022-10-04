import "./Verification.css";

export default function VerificationPage() {
    return (
        <div className="verificationPage">
            <div className={"verifyPanel"}>
                <p>
                    Check you email in order to verify this account.
                </p>
                <a href={"https://www.gmail.com"} target={"_blank"}>
                    Go to email
                </a>
            </div>
        </div>
    );
}